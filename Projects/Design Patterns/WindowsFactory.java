public class WindowsFactory implements UserInterfaceFactory{
    public UserInterface getUserInterface(String os){
        return new WindowsUserInterface();
    }
}
