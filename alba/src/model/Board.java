package model;

public class Board {
   private int num;                  
   private String title;               
   private String writer;            
   private String content;            
   private String writeday;         
   private int readnum;
   public Board(int num, String title, String writer, String content) {
      super();
      this.num = num;
      this.title = title;
      this.writer = writer;
      this.content = content;
   }
   public Board(int num, String title, String writer, String content, String writeday, int readnum) {
      super();
      this.num = num;
      this.title = title;
      this.writer = writer;
      this.content = content;
      this.writeday = writeday;
      this.readnum = readnum;
   }
   public Board(String title, String writer, String content) {
      super();
      this.title = title;
      this.writer = writer;
      this.content = content;
   }
   public Board() {
      super();
      // TODO Auto-generated constructor stub
   }
   public int getNum() {
      return num;
   }
   public void setNum(int num) {
      this.num = num;
   }
   public String getTitle() {
      return title;
   }
   public void setTitle(String title) {
      this.title = title;
   }
   public String getWriter() {
      return writer;
   }
   public void setWriter(String writer) {
      this.writer = writer;
   }
   public String getContent() {
      return content;
   }
   public void setContent(String content) {
      this.content = content;
   }
   public String getWriteday() {
      return writeday;
   }
   public void setWriteday(String writeday) {
      this.writeday = writeday;
   }
   public int getReadnum() {
      return readnum;
   }
   public void setReadnum(int readnum) {
      this.readnum = readnum;
   }
   @Override
   public String toString() {
      return "Board [num=" + num + ", title=" + title + ", writer=" + writer + ", content=" + content + ", writeday="
            + writeday + ", readnum=" + readnum + "]";
   }
}