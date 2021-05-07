import java.io.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Logger
{

  private File logFile;
  private static Logger instance;
  private static Lock lock = new ReentrantLock();

  private Logger()
  {
    logFile = new File("LogFile.txt");
  }

  /** A simpleton , returning an instance of Logger */
  public static Logger getInstance()
  {
    if (instance == null)
    {
      synchronized (lock)
      {
        if (instance == null)
        {
          instance = new Logger();
        }
      }

    }
    return instance;
  }

  /** A method to write a text to file */
  public void log(String text)
  {
    try
    {
      Writer out = new BufferedWriter(new FileWriter(logFile, true));
      out.append(text);
      out.flush();
      out.close();
    }
    catch (IOException e)
    {
      System.out.println("File error");
    }
  }
}
