/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        int size = size();
        for (int i = 0; i < size; i++) storage[i] = null;
    }

    void save(Resume r) {
        //нужна проверка на превышение размера массива
        int index = 0;
        if (size() > 0) {
            index = size();
        }
        storage[index] = r;
    }

    Resume get(String uuid) {

        for (int i = 0; i < size(); i++) {
            if (storage[i].uuid.equals(uuid)) return storage[i];
        }

        return null;
    }

    void delete(String uuid) {
        int index = 0;
        //find index of uuid
        for (int i = 0; i < size(); i++) {
            if (storage[i].uuid.equals(uuid)) {
                index = i;
                break;
            }
        }
        //shift
        while (storage[index + 1] != null) {
            storage[index] = storage[index + 1];
            index++;
        }
        storage[index] = null;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumes = new Resume[size()];
        for (int i = 0; i < size(); i++)
            resumes[i] = storage[i];
        return resumes;
    }

    int size() {

        int count = 0;

        while (storage[count] != null) {
            count++;
        }
        return count;
    }
}
