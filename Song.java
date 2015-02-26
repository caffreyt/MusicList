import java.util.Comparator;

public class Song implements Comparable<Song>{
  
  public String artist;
  public String name;
  public int year;
  public double score;
  public String notes;
  // More fields here
  
  // Default constructor.. you'll need to modify this
  public Song(String artist, String name, int year, double score, String notes) { 
    this.artist = artist;
    this.name = name;
    this.year = year;
    this.score = score;
    this.notes = notes;
  }
  
  public int compareTo(Song compareSong) {
 
  
 
  //ascending order
  return name.compareTo(compareSong.name);
 
  //descending order
  //return compareQuantity - this.quantity;
 
 }
  
  
 public static Comparator<Song> SongNameComparator 
                          = new Comparator<Song>() {
 
     public int compare(Song song1, Song song2) {
 
       String songName1 = song1.name.toUpperCase();
       String songName2 = song2.name.toUpperCase();
 
       //ascending order
       return songName1.compareTo(songName2);
 
       //descending order
       //return fruitName2.compareTo(fruitName1);
     }
 
 };
  /* ADD YOUR CODE HERE */
  
}
