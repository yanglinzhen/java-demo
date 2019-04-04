package demo.classloader;

import demo.BaseDemo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CCRun implements BaseDemo {

    @Override
    public void runDemo(String[] args) {
       String progClass = "demo/classloader/Foo";
        String progArgs[] = new String[]{
                "Bar.class",
                "Foo.class"
        };
//        System.arraycopy(args, 1, progArgs, 0, progArgs.length);

        CCLoader ccl = new CCLoader(CCRun.class.getClassLoader());
        Class clas = null;
        try {
            clas = ccl.loadClass(progClass);
            Class mainArgType[] = { (new String[0]).getClass() };
            Method main = clas.getMethod("main", mainArgType);
            Object argsArray[] = { progArgs };
            main.invoke(null, argsArray);

            // Below method is used to check that the Foo is getting loaded
            // by our custom class loader i.e CCLoader
            Method printCL = clas.getMethod("printCL", null);
            printCL.invoke(null, new Object[0]);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}