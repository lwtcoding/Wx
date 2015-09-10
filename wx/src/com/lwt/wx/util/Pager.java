package com.lwt.wx.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class Pager<E> {
	 private static int DEFAULT_PAGE_SIZE = 10;

	    private int pageNumber;//�ڼ�ҳ
	    private int pageSize = DEFAULT_PAGE_SIZE;//ÿҳ���ټ�¼��Ĭ��Ϊ 10
	    private long totalRecordsCount;//һ����������¼
	    private long totalPagesCount;//һ������ҳ

	    private List<E> objectsList;//�����

	    //û�����ݵ�ʱ�򷵻�һ����ҳ�����
	    /**
	     * The empty page (immutable).  This page is serializable.
	     */
	    public static final Pager EMPTY_PAGE = new Pager(0, DEFAULT_PAGE_SIZE, 0, Collections.emptyList());


	    public Pager()
	    {
	        this.pageNumber = 0;
	        this.pageSize = DEFAULT_PAGE_SIZE;
	        this.totalRecordsCount = 0;
	        this.objectsList = new ArrayList<E>();
	    }

	    public Pager(int pageNumber, int pageSize, long totalRecordsCount, List<E> objectsList)
	    {
	        this.pageNumber = pageNumber;
	        this.pageSize = pageSize;
	        this.totalRecordsCount = totalRecordsCount;
	        this.objectsList = new ArrayList<E>(objectsList);
	    }


	    public String toString()
	    {
	        StringBuilder toString = new StringBuilder();
	        
	        toString.append("\npageNumber = ");
	        toString.append(pageNumber);
	        
	        toString.append("\npageSize = ");
	        toString.append(pageSize);
	        
	        toString.append("\ntotalRecordsCount = ");
	        toString.append(totalRecordsCount);
	        
	        toString.append("\ntotalPagesCount = ");
	        toString.append(this.getTotalPagesCount());
	        
	        toString.append("\nhasNextPage = ");
	        toString.append(this.hasNextPage());
	        
	        toString.append("\nhasPreviousPage = ");
	        toString.append(this.hasPreviousPage());
	        
	        toString.append("\nstartIndex = ");
	        toString.append(Pager.getStartIndex(this.pageNumber, this.pageSize));
	        
	        toString.append("\nobjectsList = ");
	        toString.append(objectsList == null ? "No info." : objectsList.toString());
	                
	        toString.append("\n");
	        
	        return new String(toString);
	    }
	    
	    
	    /**
	     * @return Returns the totalPagesCount.
	     */
	     //����һ������ҳ
	    public long getTotalPagesCount()
	    {
	        if (totalRecordsCount % pageSize > 0)
	            totalPagesCount = totalRecordsCount / pageSize + 1;
	        else
	            totalPagesCount = totalRecordsCount / pageSize;
	        
	        return totalPagesCount;
	    }

	    public void setTotalPagesCount(int totalPagesCount)
	    {
	        this.totalPagesCount = totalPagesCount;
	    }


	    /**
	     * @return Returns the pageNumber.
	     */
	    public int getPageNumber()
	    {
	        return this.pageNumber;
	    }

	    public void setPageNumber(int pageNumber)
	    {
	        this.pageNumber = pageNumber;
	    }


	    /**
	     *
	     * @return Returns the totalRecordsCount.
	     */
	  //����һ����������¼
	    public long getTotalRecordsCount()
	    {
	        return this.totalRecordsCount;
	    }

	    public void setTotalRecordsCount(long totalRecordsCount)
	    {
	        this.totalRecordsCount = totalRecordsCount;
	    }


	    /**
	     * @return Returns the objectsList.
	     */
	    public List<E> getObjectsList()
	    {
	        return objectsList;
	    }

	    public void setObjectsList(List<E> objectsList)
	    {
	        this.objectsList = objectsList;
	    }


	    public boolean hasNextPage()
	    {
	        return getPageNumber() < getTotalPagesCount();
	    }

	    public boolean hasPreviousPage()
	    {
	        return getPageNumber() > 1;
	    }


	    /**
	     * @return the pageSize
	     */
	    public int getPageSize()
	    {
	        return pageSize;
	    }

	    /**
	     * @param pageSize the pageSize to set
	     */
	    public void setPageSize(int pageSize)
	    {
	        this.pageSize = pageSize;
	    }

	    //��ȡ��ʼ����
	    public static int getStartIndex(int pageNumber, int pageSize)
	    {
	        int startIndex = (pageNumber - 1) * pageSize;
	        if (startIndex < 0) {
	            startIndex = 0;
	        }
	        
	        return startIndex;
	    }


	    /**
	     * Returns <tt>true</tt> if this page contains no elements.
	     *
	     * @return <tt>true</tt> if this page contains no elements
	     */
	    public boolean isEmpty()
	    {
	        if (this.objectsList==null || this.objectsList.isEmpty()) {
	            return true;
	        }
	        
	        return false;
	    }


	    /**
	     * @return the pageSize
	     */
	    public static Pager emptyPage()
	    {
	        return new Pager();
	    }
	}

