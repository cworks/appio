package net.cworks.appio;

/**
 * A Route will match any path which follows its path immediately with a "/".
 * For example: use("/admin",...) will match "/admin" and "/admin/user" and "/admin/user/address"
 *
 * A Route is a combination of
 * Http Method, URI, and one or more Callbacks for the endpoint
 */
public interface Route {

    public void delete(String path, Callback...callbacks);

    public void get(String path, Callback...callbacks);

    public void head(String path, Callback...callbacks);

    public void patch(String path, Callback...callbacks);

    public void post(String path, Callback...callbacks);

    public void put(String path, Callback...callbacks);

    public void trace(String path, Callback...callbacks);

    public void options(String path, Callback...callbacks);

    public void connect(String path, Callback...callbacks);

}
