package JavaDesignPattern;

public class SingletonPattern implements Cloneable{
    private static SingletonPattern singleObj = null;

    private SingletonPattern() {

    }

    @Override
    public SingletonPattern clone() {
        throw new RuntimeException("Clone is not supported");
    }

    public static SingletonPattern getInstance() {
        synchronized(SingletonPattern.class) {
            if(singleObj == null) {
                singleObj = new SingletonPattern();
            }
        }
        return singleObj;
    }


}
