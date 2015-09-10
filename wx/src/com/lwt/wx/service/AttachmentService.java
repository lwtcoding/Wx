package com.lwt.wx.service;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.Thumbnails.Builder;
import net.coobird.thumbnailator.geometry.Positions;




import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import com.lwt.wx.dao.IAttachmentDao;
import com.lwt.wx.entity.Attachment;
import com.lwt.wx.entity.Topic;
import com.lwt.wx.util.SystemContext;
@Service
public class AttachmentService implements IAttachmentService {
@Resource
  private IAttachmentDao attachmentDao;
	public void add(Attachment att, InputStream in,String path) {
		
		try {
			addFile(att,in,path);
			attachmentDao.save(att);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}
	private void addFile(Attachment att, InputStream in,String uploadPath) throws IOException {
		//String Path=SystemContext.getRealPath();
		
		String path=uploadPath;
		String thumbPath=path+"thumb\\";
		
		File fp=new File(path);
		File tfp=new File(thumbPath);
		if(!fp.exists()) fp.mkdirs();
		if(!tfp.exists()) tfp.mkdirs();
		
		path=path+att.getNewName();
		thumbPath=thumbPath+att.getNewName();
		
		Builder b=Thumbnails.of(in);
		if(att.getIsImage()==1){
		BufferedImage bi=ImageIO.read(in);
		int width=bi.getWidth();
		Builder<BufferedImage> bf=Thumbnails.of(bi);
		if(width>800){
			bf.scale((double)650/(double)width);
		}else {
			bf.scale(1.0f);
		}
	
		bf.toFile(path);
		
		BufferedImage tbi=Thumbnails.of(bi).scale((double)(150*1.0)/(double)width).asBufferedImage();
		Thumbnails.of(tbi).scale(1.0f).sourceRegion(Positions.CENTER, 150, 110).toFile(thumbPath);
		}else {
			BufferedReader reader=new BufferedReader(new InputStreamReader(in));
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(path)));
			String line=null;
			while((line=reader.readLine())!=null){
				writer.write(line);
				writer.newLine();
				writer.flush();
			}
			writer.close();
			reader.close();
			
		}
		
	}
	public List<Attachment> findByProductId(Long id) {
		
		return attachmentDao.findByProductId(id);
	}
	public void deleteByName(String newName,String dirPath,Integer isImage) {
	 attachmentDao.deleteByName(newName);
	 
	 try {
		 String path=dirPath+newName;
		FileUtils.forceDelete(new File(path));
		if(isImage==1){
		String thumbPath=dirPath+"thumb\\"+newName;
		FileUtils.forceDelete(new File(thumbPath));
		}
	} catch (IOException e) {
	
		e.printStackTrace();
	}
	 
		
	}
	public void addTopicAttachs(Topic topic, Long[] attids) {
		if(attids!=null&&attids.length>0){
		for (Long id:attids){
			Attachment a=attachmentDao.get(Attachment.class, id);
			if(a==null) continue;
			a.setTopic(topic);
			attachmentDao.saveOrUpdate(a);
		}
		}
	}
	public void updateIndexPic(Long[] indexPicId) {
		if(indexPicId!=null&&indexPicId.length>0){
	      for(Long id:indexPicId){
	    	 String hql="update Attachment set isIndexPic=1 where id=?";
	    	 attachmentDao.executeHql(hql, new Object[]{id});
	      }
		}
	}
	public void updateIsAttach(Long[] attachId) {
if(attachId!=null&&attachId.length>0){
		for(Long id:attachId){
	    	 String hql="update Attachment set isAttach=1 where id=?";
	    	 attachmentDao.executeHql(hql, new Object[]{id});
	      }
	}
	}


}
