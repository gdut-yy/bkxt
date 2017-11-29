package util;

import java.io.Serializable;
import java.util.List;

public class PageModel<T> implements Serializable {
	  private static final long serialVersionUID = 1L;
		private int pageSize = 10;
		private int pageNo = 1;
		private int recordCount = 0;
		private int pageCount;
		private List<T> data;
		private String pageNav;
		public PageModel(int pageSize, int pageNo, int recordCount) {
			if(pageSize < 1){
			  this.pageSize = 10;
			}else {
			  this.pageSize = pageSize;
			}
			if(recordCount!=0){
			this.pageCount = (int)((recordCount + this.pageSize - 1) / this.pageSize);
			}
			else{
				this.pageCount = 1;
			}
			
		    if(pageNo < 1){
		      this.pageNo = 1;
		    }else if(pageNo > this.pageCount){
		      this.pageNo = this.pageCount;
		    }else{
		      this.pageNo = pageNo;
		    }
			this.recordCount = recordCount;
		}
		public int getPageSize() {
			return pageSize;
		}
		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}
		public int getPageNo() {
			return pageNo;
		}
		public void setPageNo(int pageNo) {
			this.pageNo = pageNo;
		}
		public long getRecordCount() {
			return recordCount;
		}
		public void setRecordCount(int recordCount) {
			this.recordCount = recordCount;
		}
		public List<T> getData() {
			return data;
		}
		public void setData(List<T> data) {
			this.data = data;
		}
		public void setPageNav(String url){
		  if(url.lastIndexOf('?') != - 1){
	        url += "&";
	      }else{
	        url += "?";
	      }  
	      StringBuilder sb = new StringBuilder();
	      sb.append("共&nbsp;").append(recordCount).append("&nbsp;条&nbsp;&nbsp;");
	      sb.append(pageSize).append("&nbsp;条/页&nbsp;&nbsp;");
	      if (pageNo >= 2) {
	        sb.append("<a href='").append(url);
	        sb.append("pageNo=").append(1).append("&pageSize=").append(pageSize);
	        sb.append("'>首页</a>&nbsp;&nbsp;");
	        sb.append("<a href='").append(url);
	        sb.append("pageNo=").append(pageNo-1).append("&pageSize=");
	        sb.append(pageSize).append("'>上一页</a>&nbsp;&nbsp;");
	      } else {
	        sb.append("首页&nbsp;&nbsp;");
	        sb.append("上一页&nbsp;&nbsp;");
	      }    
	      if (pageNo  <= pageCount - 1 && pageCount != 0) {
	        sb.append("<a href='").append(url);
	        sb.append("pageNo=").append(pageNo+1).append("&pageSize=");
	        sb.append(pageSize).append("'>下一页</a>&nbsp;&nbsp;");
	        sb.append("<a href='").append(url);
	        sb.append("pageNo=").append(pageCount).append("&pageSize=");
	        sb.append(pageSize).append("'>尾页</a>&nbsp;&nbsp;");
	      } else {
	        sb.append("下一页&nbsp;&nbsp;");
	        sb.append("尾页&nbsp;&nbsp;");
	      }     
	      sb.append("跳转到第&nbsp;").append("<select>");
	      for(int i = 1; i <= pageCount; i++){
	        if(pageNo != i){
	          sb.append("<option onclick=\"location.href='").append(url);
	          sb.append("pageNo=").append(i);
	          sb.append("&pageSize=").append(pageSize).append("';\">");
	          sb.append("&nbsp;").append(i).append("/").append(pageCount);
	          sb.append("&nbsp;").append("</option>");
	        }else {
	          sb.append("<option selected='selected' onclick=\"location.href='");
	          sb.append(url).append("pageNo=").append(i);
	          sb.append("&pageSize=").append(pageSize).append("';\">");
	          sb.append("&nbsp;").append(i).append("/").append(pageCount);
	          sb.append("&nbsp;").append("</option>");
	        }
	       }
	      sb.append("</select>&nbsp;页");      
		  this.pageNav = sb.toString();
		}	
		public String getPageNav(){
		  return pageNav;
		}
}
