package com.softpager.sbsd.demosecurity;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoSecurityApplicationTests {

/*
    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;


    @Before
    public void initDB() {
        {
            User newUser = new User("user@user.com", "Sam", "Jeff", "123456");
            userService.createUser(newUser);
        }
        {
            User adminUser = new User("user@admin.com", "Sam", "Moore", "123456");
            userService.createAdmin(adminUser);
        }

        Task userTask = new Task("do some task");
        User theUser = userService.getUser("user@user.com");
        taskService.createTask(userTask, theUser);
    }

    @Test
    public void testUser() {
        User theUser = userService.getUser("user@user.com");
        assertNotNull(theUser);

        User testAdmin = userService.getUser("user@admin.com");
        assertEquals(testAdmin.getEmail(), "user@admin.com");
    }

    @Test
    public void getTastByUser() {
        User theUser = userService.getUser("user@user.com");
        List<Task> userTask = taskService.findUserTask(theUser);
        assertNotNull(userTask);
    }*/
}
