package practise_3;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

public class SetLock<E> implements Set {
    ReentrantLock lock = new ReentrantLock();
    Set<E> set = new HashSet();
    @Override
    public int size() {
        lock.lock();
        int size = set.size();
        lock.unlock();
        return size;
    }

    @Override
    public boolean isEmpty() {
        lock.lock();
        boolean flag = set.isEmpty();
        lock.unlock();
        return flag;
    }

    @Override
    public boolean contains(Object o) {
        lock.lock();
        boolean cont = set.contains(o);
        lock.unlock();
        return cont;
    }

    @Override
    public Iterator iterator() {
        lock.lock();
        Iterator it = set.iterator();
        lock.unlock();
        return it;
    }

    @Override
    public Object[] toArray() {
        lock.lock();
        Object[] ob = set.toArray();
        lock.unlock();
        return ob;
    }

    @Override
    public boolean add(Object o) {
        lock.lock();
        boolean k = set.add((E)o);
        lock.unlock();
        return k;
    }

    @Override
    public boolean remove(Object o) {
        lock.lock();
        boolean k = set.remove((E)o);
        lock.unlock();
        return k;
    }

    @Override
    public boolean addAll(Collection c) {
        lock.lock();
        boolean fl = set.addAll(c);
        lock.unlock();
        return fl;
    }

    @Override
    public void clear() {
        lock.lock();
        set.clear();
        lock.unlock();
    }

    @Override
    public boolean removeAll(Collection c) {
        lock.lock();
        boolean f = set.removeAll(c);
        lock.unlock();
        return f;
    }

    @Override
    public boolean retainAll(Collection c) {
        lock.lock();
        boolean f = set.retainAll(c);
        lock.unlock();
        return f;
    }

    @Override
    public boolean containsAll(Collection c) {
        lock.lock();
        boolean f = set.containsAll(c);
        lock.unlock();
        return f;
    }

    @Override
    public Object[] toArray(Object[] a) {
        lock.lock();
        Object[] ob = set.toArray(a);
        lock.unlock();
        return ob;
    }
}
