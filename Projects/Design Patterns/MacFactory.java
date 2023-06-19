public class MacFactory implements UserInterfaceFactory{
    public UserInterface getUserInterface(String os){
        return new MacUserInterface();
    }
}
