package com.codeway.user.service;

import com.codeway.pojo.QueryVO;
import com.codeway.pojo.user.Resource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResourceServiceTest {

    @Autowired
    private ResourceService resourceService;

    @Test
    public void findResourceByCondition() {
        QueryVO queryVO = new QueryVO();
        List<Resource> dictByCondition = resourceService.findResourceByCondition(new Resource(), queryVO);
        Assert.assertTrue(dictByCondition.size() > 0);

    }

    @Test
    public void findResourceById() {
        Resource resourceById = resourceService.findResourceById("1136504053649920002");
        Assert.assertNotNull(resourceById);
    }

    @Test
    public void findResourceByRoleIds() {
        Set<Resource> resourceByRoleIds = resourceService.findResourceByRoleIds(Arrays.asList("1119477963140296706"));
        Assert.assertNotNull(resourceByRoleIds);
    }

    @Test
    public void saveOrUpdate() {
        Resource resource = new Resource();
        resource.setName("1234");
        resource.setDescription("描述");
        resourceService.saveOrUpdate(resource);
    }

    @Test
    public void deleteByIds() {
        resourceService.deleteByIds(Arrays.asList("1200696171232890880"));
    }
}
