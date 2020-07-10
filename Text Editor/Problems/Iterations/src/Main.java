import javax.security.auth.callback.Callback;

class IteratorExecutor {

    static void performIterationsWithCallback(int numberOfIterations, LoopCallback callback) {
        for (int i = 0; i < numberOfIterations; i++) {
            callback.onNewIteration(i);
        }
    }

    static void startIterations(int numberOfIterations) {
        // invoke the method performIterationsWithCallback here
        LoopCallback callback = new LoopCallback() {
            @Override
            public void onNewIteration(int interation) {
                System.out.println("Iteration: " + interation);
            }
        };

        performIterationsWithCallback(numberOfIterations, callback);
    }
}

// Don't change the code below
interface LoopCallback {

    void onNewIteration(int iteration);
}