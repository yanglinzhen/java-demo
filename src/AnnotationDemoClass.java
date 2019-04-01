import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

@JavaFileInfo
public class AnnotationDemoClass implements BaseDemoClass {

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
    public void runDemo() {
        AnnotationDemoClass annotationDemoClass = new AnnotationDemoClass();

        AnnotationDemoClass.readAnnotationOn(annotationDemoClass.getClass());

        try {
            AnnotationDemoClass.readAnnotationOn(annotationDemoClass.getClass().getMethod("getString", new Class[]{}));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
