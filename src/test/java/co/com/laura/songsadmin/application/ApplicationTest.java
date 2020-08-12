package co.com.laura.songsadmin.application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.laura.songsadmin.SongsAdminApplication;

@RunWith(SpringRunner.class)
public class ApplicationTest {
  @Test
  public void applicationStarts() {
    SongsAdminApplication.main(new String[] {});
  }
}