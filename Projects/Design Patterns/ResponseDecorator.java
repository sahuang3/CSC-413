public abstract class ResponseDecorator implements ResponseGenerator{
    private final ResponseGenerator generator;
    public ResponseDecorator(ResponseGenerator generator){
        this.generator = generator;
    }

    public void reply(String name) {
        generator.reply(name);
    }
}
