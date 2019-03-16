using Microsoft.EntityFrameworkCore;

namespace RecipeAPI.Models
{
    public class RecipesContext : DbContext
    {

        public RecipesContext(DbContextOptions<RecipesContext> options)
            : base(options)
        {
        }

        public DbSet<Recipes> Recipes { get; set; }
    }
}
