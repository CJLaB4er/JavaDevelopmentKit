package anonymousClases;

public class Main {
    public interface MouseListener {
        void mouseDown();

        void mouseUp();
    }

    private static class MouseAdapter implements MouseListener {
        @Override
        public void mouseDown() {
            System.out.println("Мышку нажали");
        }

        @Override
        public void mouseUp() {
            System.out.println("Мышку отпустили");
        }
    }

    private static void addMouseListener(MouseListener l) {
        l.mouseDown();
        l.mouseUp();
    }

    public static void main(String[] args) {
        MouseAdapter m = new MouseAdapter();
        addMouseListener(m);
        addMouseListener(new MouseAdapter());
        MouseListener l = new MouseListener() {
            @Override
            public void mouseDown() {

            }

            @Override
            public void mouseUp() {

            }
        };
        addMouseListener(l);
        addMouseListener(new MouseListener() {
            @Override
            public void mouseDown() {

            }

            @Override
            public void mouseUp() {

            }
        });
    }
}

