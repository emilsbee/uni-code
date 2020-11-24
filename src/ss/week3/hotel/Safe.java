package ss.week3.hotel;

public class Safe {
    protected boolean active;
    protected boolean open;

    public Safe() {
        this.active = false;
        this.open = false;
    }

    public void activate() {
        this.active = true;
    }

    public void deactivate() {
        this.open = false;
        this.active = false;
    }

    public void open() {
        if (this.active) {
            this.open = true;
        }
    }

    public void close() {
        this.open = false;
    }

    public boolean isActive() {
        return this.active;
    }

    public  boolean isOpen() {
        return this.open;
    }

}
