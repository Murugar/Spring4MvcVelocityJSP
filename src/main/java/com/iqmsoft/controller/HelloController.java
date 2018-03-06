package com.iqmsoft.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iqmsoft.model.ExampleForm;

@Controller
@RequestMapping("/")
public class HelloController {

  @RequestMapping(value = "", method = RequestMethod.GET)
  public String home(final ModelMap modelMap) {
    return showForm("jsp", modelMap);
  }

  @RequestMapping(value = "{template}", method = RequestMethod.GET)
  public String showForm(@PathVariable(value = "template") final String template,
                         final ModelMap model) {
    final List<String> words = Arrays.asList
    		("Test2", "<marquee>Test4</marquee>", "Test3");
    model.addAttribute("words", words);
    final ExampleForm form = new ExampleForm();
    form.setWord("Test5");
    model.addAttribute("form", form);
    return "index-" + template;
  }

  @RequestMapping(value = "{template}", method = RequestMethod.POST)
  public String handleForm(@PathVariable(value = "template") final String template,
                           @ModelAttribute("form") final ExampleForm formBean,
                           final ModelMap modelMap) {
    modelMap.addAttribute("form", formBean);
    return "result-" + template;
  }
}