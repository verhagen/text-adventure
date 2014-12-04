package sample;

//import static org.junit.Assert.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;


import org.jbehave.core.annotations.Aliases;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class GridSteps { // Look, Ma', I'm a POJO!
    
    private Game game;
    private StringRenderer renderer;
 
    @Given("a $width by $height game")
    @Aliases(values={"a new game: $width by $height"})
    public void theGameIsRunning(int width, int height) {
        game = new Game(width, height);
    }
     
    @When("I toggle the cell at ($column, $row)")
    public void iToggleTheCellAt(int column, int row) {
        game.toggleCellAt(column, row);
    }
     
    @Then("the grid should look like $grid")
    @Aliases(values={"the grid should be $grid"})
    public void theGridShouldLookLike(String grid) {
        renderer = new StringRenderer();
        game.visit(renderer);
        
//        System.err.println("Game\n" + renderer.asString());
//        System.err.println("Should be like\n" + grid);

        assertThat(renderer.asString(), equalTo(grid));
    }
 
}