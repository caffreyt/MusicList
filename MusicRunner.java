import java.util.Arrays;

import java.util.*;

public class MusicRunner

{

 public static String removeQuotes(String input)

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

     int year;

     double score;

   

     try

     {

         year = Integer.parseInt(removeQuotes(data[3]));

     }   

     catch (Exception e)

     {

       year = 0;

     }

   

     try

     {

       score = Double.parseDouble(removeQuotes(data[4]));

     }

     catch (Exception e)

     {

       score = 0;

     }

   

     Song song = new Song(removeQuotes(data[0]), removeQuotes(data[1]), year, score, data[16]);  // data[0] is the artist and data[1] is the name

    if(removeQuotes(data[2]).equals("song"))

    {

      Songs.addSong(song);

     count++;

    }

     if (count == 1000)  // For now only read ONE song

       break;

   

     data = mr.getSongData();  // Get next line of song data

    }

    Songs.Sort(2);

   

    for(int i = 1; i <=Songs.size(); i++)

    {

     Song song = Songs.getSong(i);

     System.out.println("Artist: \""+song.artist + "\" Title: \"" + song.name+"\"");

   

    }

    System.out.println("List a number from 0-9");

    Scanner scanner = new Scanner(System.in);

    System.out.println(Songs.getSong(scanner.nextInt()).notes);

    mr.close();

 }

}