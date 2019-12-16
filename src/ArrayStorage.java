/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size=0;
    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size=0;
    }

    void save(Resume r) {
        int index = 0;
        if (size > 0) {
            index = size;
        }
        storage[index] = r;
        size++;
    }

    Resume get(String uuid) {
       for (int i = 0; i < size()-1; i++) {
            if (storage[i].uuid.equals(uuid)){
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int index = 0;
        //find index of uuid
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                index = i;
                break;
            }
        }
        //shift
        while (index  != size-1) {
            storage[index] = storage[index + 1];
            index++;
        }
        storage[index] = null;
        size--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumes = new Resume[size];
        for (int i = 0; i < size; i++){
            resumes[i] = storage[i];
        }
        return resumes;
    }

    int size() {
        return size;
    }
}
