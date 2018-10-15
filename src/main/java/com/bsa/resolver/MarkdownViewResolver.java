package com.bsa.resolver;

import org.springframework.web.servlet.view.AbstractTemplateViewResolver;

public class MarkdownViewResolver extends AbstractTemplateViewResolver {
    public MarkdownViewResolver() {
        setViewClass(requiredViewClass());
    }

    @Override
    protected Class<?> requiredViewClass() {
        return MarkdownView.class;
    }

}
