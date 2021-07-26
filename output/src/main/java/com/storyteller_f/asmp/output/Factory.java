package com.storyteller_f.asmp.output;

import com.storyteller_f.asmp.output.map.Output;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface Factory {
    default Output get(String type) {
        try {
            String className = getClass().getPackage().getName() + "." + type + "Output";
            Class<?> outputClass = Class.forName(className);
            Object o = outputClass.getConstructor().newInstance();
            if (o instanceof Output)
                return (Output) o;
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    default List<String> type() {
        try {
            return getClasses(getClass().getClassLoader(), getClass().getPackage().getName()).stream().filter(aClass -> aClass.getSimpleName().endsWith("Output")).map(Class::getSimpleName).map(s -> s.substring(0, s.lastIndexOf("Output"))).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    default List<Class<?>> getClasses(ClassLoader cl, String pack) throws Exception {
        String dottedPackage = pack.replaceAll("[/]", ".");
        if (dottedPackage.length() > 0) {
            dottedPackage += ".";
        }
        List<Class<?>> classes = new ArrayList<>();
        URL resource = cl.getResource(pack);
        if (resource != null) {
            InputStream content = (InputStream) resource.getContent();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(content));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.endsWith(".class")) {
                    String className = dottedPackage + line.substring(0, line.lastIndexOf('.'));
                    Class<?> cc = Class.forName(className);
                    classes.add(cc);
                } else {
                    //package
                    classes.addAll(getClasses(cl, line));
                }
            }
        }

        return classes;
    }
}
