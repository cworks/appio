/**
 * Created by comartin on 2/10/2015.
 */
package net.cworks.appio;

public class AppTest {


    public void testSequentially() {
        App app = new App("main");
        app.use(new Middleware() {
            @Override
            public void called(Request request, Response response, Middleware next) {
                System.out.println("This will be executed once for every request to the App.");
                System.out.println("but will not allow a request to go beyond it because it doesnt call next");
                // TODO implement next();
            }
        });

        app.get("/", new Callback() {
            @Override
            public void called(Request request, Response response) {
                // requests will never reach this Route
                response.send("Hello");
            }
        });

    }

    public void testAppLevelMiddleware() {

        App mainApp = new App("main");
        mainApp.use(new Middleware() {
            @Override
            public void called(Request request, Response response, Middleware next) {
                System.out.println("Executed for every request to the App.");
            }
        });
    }

    public void testOnMountEvent() {

        App adminApp = new App("admin");
        adminApp.onMount(new MountEvent() {
            @Override
            public void mounted(App parent) {
                System.out.println("adminApp mounted to parent: " + parent.toString());
            }
        });

        adminApp.get("/", new Callback() {
            @Override
            public void called(Request request, Response response) {
                response.send("Welcome to the Admin API");
            }
        });

        App mainApp = new App("main");
        mainApp.use("/admin", adminApp);
    }

    public void testCreateRouter() {


        Router router = App.router();

        // invoked for any request passed to this router
        router.use(new Middleware() {
            public void called(Request request, Response response, Middleware next) {
                System.out.println("Invoked for any requests passed to this router");
            }
        });

        // handle any requests that ends in /events and depends on where the router is used
        router.get("/events", new Middleware() {
            public void called(Request request, Response response, Middleware next) {
                System.out.println("Invoked for any requests that ends in /events.");
            }
        });

        // Now we can use Router for a particular URL
        App app = new App();
        // Only requests to /calendar/* will be sent to our Router.
        app.use("/calendar", router);

    }

}
