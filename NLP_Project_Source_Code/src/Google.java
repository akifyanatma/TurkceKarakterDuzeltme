import java.util.List;


public class Google {
	   private ResponseData responseData;
	    public ResponseData getResponseData() { return responseData; }
	    public void setResponseData(ResponseData responseData) { this.responseData = responseData; }
	 
	    static class ResponseData 
	    {
	        private List<Result> results;
	        public List<Result> getResults() { return results; }
	        public void setResults(List<Result> results) { this.results = results; }
	    }
	 
	    static class Result 
	    {
	        private String url;
	        private String titleNoFormatting;
	        private String content;
	        public String getUrl() { return url; }
	        public String getTitle() { return titleNoFormatting; }
	        public String getContent() { return content; }
	        public void setUrl(String url) { this.url = url; }
	        public void setTitle(String title) { this.titleNoFormatting = title; }
	        public void setContent(String content) { this.content = content; }
	    }
}
