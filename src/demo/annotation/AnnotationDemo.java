package demo.annotation;

import demo.BaseDemo;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

@JavaFileInfo
public class AnnotationDemo implements BaseDemo {

    @JavaFileInfo(author = "marco", version = "1.0")
    public String getString() {
        return null;
    }

    public static void readAnnotationOn(AnnotatedElement element) {
        Annotation[] annotations = element.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof JavaFileInfo) {
                String author = ((JavaFileInfo)annotation).author();
                String version = ((JavaFileInfo)annotation).version();
                String outputText = String.format("author: %s, version: %s", author, version);
                System.out.println(outputText);
            }
        }
    }

    @Override
    public void runDemo(String[] args) {
        AnnotationDemo annotationDemoClass = new AnnotationDemo();

        AnnotationDemo.readAnnotationOn(annotationDemoClass.getClass());

        try {
            AnnotationDemo.readAnnotationOn(annotationDemoClass.getClass().getMethod("getString", new Class[]{}));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
