package hello;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.*;
import org.apache.logging.log4j.core.appender.SyslogAppender; 
import org.apache.logging.log4j.core.BasicConfigurator;


public class SysLogger {
  private static final Logger syslogger =LogManager.getLogger(SysLogger.class.getName());
  
  
  public SysLogger()
  {
      BasicConfigurator.configure();
      SyslogAppender sa = new SyslogAppender(null, 
      "localhost:514", SyslogAppender.LOG_FTP);
      // sa.setName("SysLogger");
      // sa.setSyslogHost("localhost");
      // sa.setHeader(true);
      // sa.setLayout(new PatternLayout("%d %-5p [%c{1}] %m%n"));
      // sa.setAppend(true);
      // sa.activateOptions();
      syslogger.addAppender(sa);

      info("Hi from Java code");
  }
  
  public void info(String message){
      syslogger.info(message);
  }
}
