package net.cworks.appio;

public class AppTest {

    public void testSingleMiddleware() {
        App app = new App();
        app.use(new Middleware() {
            @Override
            public void called(Request request, Response response, Middleware next) {
                System.out.println("Called for every request to the App.");
            }
        });
    }

    public void testRouterAsMiddleware() {
        App app = new App();
        Router router = App.router();
        router.get("/", new Callback() {
            @Override
            public void called(Request request, Response response) {
                System.out.println("Called for every request to the App.");
            }
        });
        app.use(router);
    }

    public void testAppAsMiddleware() {
        App parent = new App();
        App child = new App();
        child.get("/version", new Callback() {
            @Override
            public void called(Request request, Response response) {

            }
        });
        parent.use(child);
    }

    public void testSeriesOfMiddleware() {
        Router router1 = App.router();
        router1.get("/series", new Callback() {
            @Override
            public void called(Request request, Response response) {

            }
        });

        Router router2 = App.router();
        router2.get("/series", new Callback() {
            @Override
            public void called(Request request, Response response) {

            }
        });
        App app = new App();
        // You can specify more than one Middleware function at the same path
        app.use(router1, router2);
    }

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
        App app   = new App("main");  // parent-app
        App admin = new App("admin"); // sub-app
        admin.onMount(new MountEvent() {
            @Override
            public void mounted(App parent) {
                System.out.println("adminApp mounted to parent: " + parent.toString());
            }
        });

        admin.get("/", new Callback() {
            @Override
            public void called(Request request, Response response) {
                response.send("Welcome to the Admin API");
            }
        });

        // a "sub-app" is an instance which may be used for handling the request to a Route
        app.use("/admin", admin); // mount the sub-app
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
        router.get("/events", new Callback() {
            public void called(Request request, Response response) {
                System.out.println("Invoked for any requests that ends in /events.");
            }
        });

        // Now we can use Router for a particular URL
        App app = new App();
        // Only requests to /calendar/* will be sent to our Router.
        app.use("/calendar", router);

    }

}
