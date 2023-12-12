
public enum Answer
{   

    YES("yes"), 

    NO("no"), 

    MAYBE("maybe");
    private String answer;
    private Answer(String answer){
        this.answer = answer;
    }
    
    @Override 
    public String toString(){
        return super.toString() + answer;
    }
}
