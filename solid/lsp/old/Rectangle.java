package inf4067.solid.lsp;
class Rectangle{
    protected int width;
    protected int height;
    public void setWidth(int width){
        this.width = width;
    }
    public void setHeight(int height){
        this.height = height;
    }
    public int getArea(){
        return width * height;
    }
}

class Square extends Rectangle{
    @Override
    public void setWidth(int width){
        super.setWidth(width);
        super.setHeight(width);
    }
    @Override
    public void setHeight(int height){
        super.setWidth(height);
        super.setHeight(height);
    }
}