package com.example;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;

public class ResourceLoaderTest {
	@Test  
    public void testResourceLoader() { 

           ResourceLoader loader = new DefaultResourceLoader();  
           Resource resource = loader.getResource("http://www.baidu.com");  
           System.out.println(resource instanceof UrlResource); //true  
           
           resource = loader.getResource("classpath:test.txt");  
           System.out.println(resource instanceof ClassPathResource); //true  
           
           resource = loader.getResource("test.txt");  
           System.out.println(resource instanceof ClassPathResource); //true  

    } 
}
