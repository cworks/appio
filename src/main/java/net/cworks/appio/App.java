package net.cworks.appio;

/**
 * I'm not gonna lie I drew inspiration for this idea/code from the wonderful
 * Node.js web framework, express.js (which I love love love).  However I do
 * a lot of work in Java so I'd like to have something similar...from a feature
 * and simplicity perspective.  Its NOT a Java port of express.js because I
 * don't wish to do such tedious work but from an API/clients perspective I
 * like their ideas and simplicity so I'm drawing what I like and augmenting
 * where needed.  Yes there are several other Micro Frameworks out there such
 * as SparkJava but those are fairly limited in terms of carving up URLs
 * and its tied to Jetty.  My *hope* is to separate the container from the App.
 *
 * Differences between a Route and Middleware
 *
 * Routes can provide multiple Callbacks to handle a request just like Middlewares, however
 * the difference is Callbacks can invoke next('route') to circumvent remaining Route Callbacks.
 * Middleware cannot circumvent remaining Middleware it can only call the next Middleware
 * or not call it, thereby stopping the request processing for that Route.
 *
 */
public class App {

    public App() {

    }

    // App constructors
    public App(String name) {

    }

    // App control

    /**
     * Disables the given feature.
     * @param property
     */
    public void disable(String property) {

    }

    /**
     * Returns true if the given property is disabled otherwise false
     * @param property
     * @return
     */
    public boolean disabled(String property) {
        return false;
    }

    /**
     * Enabled the given feature.
     * @param property
     */
    public void enable(String property) {

    }

    /**
     * Returns true if the given property is enabled otherwise false
     * @param property
     * @return
     */
    public boolean enabled(String property) {
        return false;
    }

    /**
     * Get the value of the given property
     * @param property
     * @return
     */
    public Object get(String property) {
        return null;
    }

    /**
     * Set the value of a given property
     * @param property
     * @param value
     */
    public void set(String property, Object value) {

    }

    // Events

    /**
     * The mount event is fired on a sub-app when it is mounted to a parent-app,
     * the parent-app is passed to the callback function.
     *
     * @param callback
     */
    public void onMount(MountEvent callback) {

    }

    // HTTP Routes

    /**
     * This method matches all HTTP verbs and is useful for mapping global logic
     * to specific path prefixes or arbitrary path matches.
     * @param path
     * @param callbacks
     */
    public void all(String path, Callback...callbacks) {

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

    // App extension and routing features

    public void param(String name, Callback...callbacks) {

    }

    public String path() {
        return null;
    }

    /**
     * Creates a Route chain for a single path.
     * @param path
     * @return
     */
    public Route route(String path) {
        return null;
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
     * Will attach Middleware to the App level (i.e. root path)
     * @param middlewares
     */
    public void use(Middleware...middlewares) {

    }










}
