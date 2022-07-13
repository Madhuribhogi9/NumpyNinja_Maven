package Loggers;
import org.apache.logging.log4j.*;
import org.testng.annotations.Test;


public class log4jPractice
{
    private static Logger demologger = LogManager.getLogger(log4jPractice.class);

        @Test
        public void sample()
        {
            demologger.info("its info msg");
            demologger.error("its error msg");
            demologger.debug("its debug msg ");
            demologger.fatal("its fatal msg");
            demologger.warn("its warn msg");
        }
    }

