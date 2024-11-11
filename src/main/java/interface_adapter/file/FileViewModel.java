package interface_adapter.file;

import interface_adapter.ViewModel;

/**
 * The ViewModel for the FileView.
 */
public class FileViewModel extends ViewModel<FileState> {
    public FileViewModel() {
        super(null);
        setState(new FileState());
    }
}
