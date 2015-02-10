/**
 * Created by comartin on 2/10/2015.
 */
package net.cworks.appio;

/**
 * Used to create a modular mountable Route callbacks, a Router instance is a
 * complete Middleware and Routing system.
 *
 * A Router contains Middleware and Routes and is a kind of mini-App capable
 * of performing Middleware and Routing functions.
 */
public abstract class Router implements Middleware {

    /**
     * Enable case sensitivity
     */
    private boolean caseSensitive = false;

    /**
     * Enables strict Routing such that /hello and /hello/ are considered different
     */
    private boolean strictRouting = false;

    /**
     * Will attach Middleware to the App level (i.e. root path)
     * @param middlewares
     */
    public void use(Middleware...middlewares) {

    }

    /**
     * Mounts the Middleware instances to the following path.
     *
     * A Route will match any path which follows its path immediately with a "/",
     * for example use("/admin", ...) will match /admin, /admin/settings, /admin/settings/users
     * etc.
     *
     * Mounting a Middleware to a path will cause the Middleware to be called when the base
     * of the path matches the specified path.
     *
     * For example use("/", ...) will call each Middleware specified for every request to the App.
     *
     * Middleware are executed in order and a if a Middleware neglects to invoke called on the next
     * Middleware then requests will never go beyond the terminal Middleware.
     * @param path the path parameter is treated as a prefix.
     * @param middlewares
     */
    public void use(String path, Middleware...middlewares) {

    }

    /**
     * Routes an Http request to the specified path with the specified callbacks.
     * The Callback functions work similar to Middleware except they can invoke
     * next('route') to skip remaining callbacks on the path.  This method can be
     * used to impose a pre-condition on a route.
     * @param path
     * @param callbacks
     */
    public void delete(String path, Callback...callbacks) {

    }

    public void get(String path, Callback...callbacks) {

    }

    public void head(String path, Callback...callbacks) {

    }

    public void patch(String path, Callback...callbacks) {

    }

    public void post(String path, Callback...callbacks) {

    }

    public void put(String path, Callback...callbacks) {

    }

    public void trace(String path, Callback...callbacks) {

    }

    public void options(String path, Callback...callbacks) {

    }

    public void connect(String path, Callback...callbacks) {

    }


}
