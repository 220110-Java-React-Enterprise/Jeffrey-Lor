package ui;

import java.util.Scanner;

import collections.CustomArrayList;
import collections.CustomListInterface;

public class ViewManager {
    private static ViewManager viewManager;
    private boolean running;
    private final Scanner scan;
    private CustomListInterface<View> viewList;
    private View nextView;

    private ViewManager() {
        this.running = true;
        scan = new Scanner(System.in);
        viewList = new CustomArrayList<>();
    }

    public static ViewManager getViewManager() {
        if (viewManager == null) {
            viewManager = new ViewManager();
        }
        return viewManager;
    }

    // Sets the nextView to the given destination if it exists in the viewList
    public void navigate(String destination) {
        for (View view : viewList) {
            if (view.viewName.equals(destination)) {
                nextView = view;
            }
        }
    }

    public void render() {
        nextView.renderView();
    }

    public void addView(View view) {
        viewList.add(view);
    }

    public void quit() {
        running = false;
    }

    public Scanner getScanner() {
        return scan;
    }

    public boolean isRunning() {
        return running;
    }
}
