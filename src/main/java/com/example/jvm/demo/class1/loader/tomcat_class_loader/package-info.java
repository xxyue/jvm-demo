package com.example.jvm.demo.class1.loader.tomcat_class_loader;
/**
 *
 * 双亲委派模型的工作过程是：
 *          如果一个类加载器收到了类加载的请求，它首先不会自己去尝试加载这个类，而是把这个请求委派给父类加载器去完成，
 *          每一个层次的类加载器都是如此，因此所有的加载请求最终都应该传送到顶层的启动类加载器中，
 *          只有当父加载器反馈自己无法完成这个加载请求（它的搜索范围中没有找到所需的类）时，子加载器才会尝试自己去加载。
 *
 * tomcat类加载器（非双亲）
 *      加载器     目录      解释
 *     CommonClassLoader       /common/*             类库可被Tomcat和所有的Web应用程序共同使用(/lib)
 *     CatalinaClassLoader     /server/*             类库可被Tomcat使用，对所有的Web应用程序都不可见。
 *     SharedClassLoader       /shared/*            类库可被所有的Web应用程序共同使用，但对Tomcat自己不可见。
 *     WebappClassLoader       /WebApp/WEB-INF/*    类库仅仅可以被此Web应用程序使用，对Tomcat和其他Web应用程序都不可见。
 *     JasperLoader
 *
 *
 * OSGi：灵活的类加载器架构
 *
 *
 *
 *
 *
 *
 *
 *
 */

