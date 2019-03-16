using System;
using System.ComponentModel.DataAnnotations;

namespace RecipeAPI.Models
{
    public class Recipes
    {
        [Key]
        public int Recipe_id { get; set; }

        [Required]
        public String RecipeName { get; set; }

        [Required]
        public String Difficulty { get; set; }

        [Required]
        public double Duration { get; set; }
        //Change so its like ca with Rtae and Blood App

        public override string ToString()
        {
            return RecipeName + " " + Difficulty + " " + Duration;
        }
    }
}
