package LogDeal;

public class LogType {
	private int type;
	private int usernameLength;
	private String username;
	private int dateLength;
	private String date;
	private int newsLength;
	private String news;
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getUsernameLength() {
		return usernameLength;
	}
	public void setUsernameLength(int usernameLength) {
		this.usernameLength = usernameLength;
	}
	public String getUsername() {
		return username;
	}
	public void setUername(String username) {
		this.username = username;
	}
	public int getDateLength() {
		return dateLength;
	}
	public void setDateLength(int dateLength) {
		this.dateLength = dateLength;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getNewsLength() {
		return newsLength;
	}
	public void setNewsLength(int newsLength) {
		this.newsLength = newsLength;
	}
	public String getNews() {
		return news;
	}
	public void setNews(String news) {
		this.news = news;
	}
	public LogType(int type, int usernameLength, String username, int dateLength, String date, int newsLength,
			String news) {
		super();
		this.type = type;
		this.usernameLength = usernameLength;
		this.username = username;
		this.dateLength = dateLength;
		this.date = date;
		this.newsLength = newsLength;
		this.news = news;
	}
	@Override
	public String toString() {
		return type + "\t" + username + "\t" + date + "\t" + news;
	}
	
}
