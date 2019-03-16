using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using RecipeAPI.Models;
// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace RecipeAPI.Controllers
{
    [Produces("application/json")]
    [Route("api/recipes")]
    [ApiController]
    public class RecipeController : ControllerBase
    {
        private readonly RecipesContext _context;

        public RecipeController(RecipesContext context)
        {
            _context = context;

        }

        [HttpGet("all")]
        // GET api/recipes/all
        public IEnumerable<Recipes> GetAllEntries()
        {
            var entries = _context.Recipes.OrderBy(e => e.RecipeName);
            return entries;
        }

        [HttpGet("recipesID/{Recipe_id}", Name = "GetEntry")]
        // GET api/recipes/recipeID/1
        public IActionResult GetEntry(int _ID)
        {
            // LINQ query, find matching entry for number
            var entry = _context.Recipes.FirstOrDefault(e => e.Recipe_id == _ID);
            if (entry == null)
            {
                return NotFound();
            }
            return Ok(entry);
        }

        // GET: api/Recipes/5
        [HttpGet("{id}")]
        public async Task<IActionResult> GetRecipes([FromRoute] int id)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            var recipes = await _context.Recipes.FindAsync(id);

            if (recipes == null)
            {
                return NotFound();
            }

            return Ok(recipes);
        }

    }

}
