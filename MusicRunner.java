import java.util.Arrays;
import java.util.*;

public class MusicRunner
{
  
  public static String fuckyoutanczos(String input)
  {return input.substring(1,input.length()-1);}
  
  public static void main (String[] args)
  {
    MusicLibrary Songs = new MusicLibrary();
    int count = 0;
    MusicReader mr = new MusicReader();
    
    mr.open("musiclist.csv");
    
    String[] data = mr.getSongData();
    
    // First line contains all the fields - We don't want to save this anywhere but we can
    // print it for now to see what information we have.
    // System.out.println(Arrays.toString(data));
    
    data = mr.getSongData();  // Get next line of song data
    
    // if data is null then we were unable to read a line of song data, so
    // this loop will continue to read lines of song data as long as there
    // IS song data available
    while (data != null)
    {
      // You probably will comment this out but for now print out the line so you can see what is there
      
      
      // Let's try to create a Song object
      Song song = new Song(fuckyoutanczos(data[0]), fuckyoutanczos(data[1]), Integer.parseInt(fuckyoutanczos(data[3])), Double.parseDouble(fuckyoutanczos(data[4])), data[16]);  // data[0] is the artist and data[1] is the name
     if(fuckyoutanczos(data[2]).equals("song"))
     {
       Songs.add(song);
      count++;
     } 
      if (count == 10)  // For now only read ONE song
        break;
      
      data = mr.getSongData();  // Get next line of song data
    }
    
    
    for(int i = Songs.size() - 1; i >=0; i--)
    {
      Song song = Songs.get(i);
      System.out.println("Artist: \""+song.artist + "\" Title: \"" + song.name+"\""); 
      
    }
    
    mr.close();
  }
}