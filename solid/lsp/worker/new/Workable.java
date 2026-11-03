package inf4067.solid.lsp;
interface Workable{
    void work();
}

interface Eatable extends Workable {
    void eat();
}