/**
 * Created by comartin on 2/10/2015.
 */
package net.cworks.appio;

/**
 * Middleware is one or more functions invoked in-order by the Routing
 * code before the final request handler is called.  Thus its called
 * Middleware because its sandwiched between the raw request and the
 * final targeted Route.  The Middleware is maintained as a Stack.
 *
 * Middleware with an optional path parameter can be loaded at the App level
 * or at the Router level.
 *
 * Mounting a Middleware at a path will cause the Middleware to execute when
 * the base of the requested path matches the path.  For example
 *
 * This Route would only execute the Callback when GET /users is called exactly
 * get("/users", ...)
 *
 * The Middleware would execute for ANY request that starts with "/users".
 * use("/users",...)
 *
 */
public interface Middleware {

    public void called(Request request, Response response, Middleware next);
}
