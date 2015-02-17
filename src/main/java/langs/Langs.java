package langs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.testng.Reporter;

public class Langs
{
  public static HashMap<String, String> lang = new HashMap();
  
  public static String getLang(String text)
  {
    if (lang.isEmpty()) {
      try
      {
        init();
      }
      catch (IOException ex)
      {
        Logger.getLogger(Langs.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    return (String)lang.get(text);
  }
  
  private static void init()
    throws FileNotFoundException, IOException
  {
    String line = null;
    String langFile = "languages_desktop.csv";
    //String langFile = "D:\\workspace\\GocietyFirstTest\\src\\main\\resources\\languages_desktop.csv";
    
    BufferedReader br = new BufferedReader(new FileReader(langFile));
    while ((line = br.readLine()) != null) {
      if (!line.trim().isEmpty())
      {
        String[] afterSplit = line.split(";");
        lang.put(afterSplit[0], afterSplit[1]);
      }
    }
    Reporter.log("Langs from: " + langFile, true);
  }
  
  public static String getLangWithNumber(String text, String addedText)
  {
    String newText = text.replaceAll("\\{0}", addedText);
    return newText;
  }
}
