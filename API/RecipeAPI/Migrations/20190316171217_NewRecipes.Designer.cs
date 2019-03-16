﻿// <auto-generated />
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Infrastructure;
using Microsoft.EntityFrameworkCore.Metadata;
using Microsoft.EntityFrameworkCore.Migrations;
using Microsoft.EntityFrameworkCore.Storage.ValueConversion;
using RecipeAPI.Models;

namespace RecipeAPI.Migrations
{
    [DbContext(typeof(RecipesContext))]
    [Migration("20190316171217_NewRecipes")]
    partial class NewRecipes
    {
        protected override void BuildTargetModel(ModelBuilder modelBuilder)
        {
#pragma warning disable 612, 618
            modelBuilder
                .HasAnnotation("ProductVersion", "2.2.3-servicing-35854")
                .HasAnnotation("Relational:MaxIdentifierLength", 128)
                .HasAnnotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn);

            modelBuilder.Entity("RecipeAPI.Models.Recipes", b =>
                {
                    b.Property<int>("Recipe_id")
                        .ValueGeneratedOnAdd()
                        .HasAnnotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn);

                    b.Property<string>("Difficulty")
                        .IsRequired();

                    b.Property<double>("Duration");

                    b.Property<string>("RecipeName")
                        .IsRequired();

                    b.HasKey("Recipe_id");

                    b.ToTable("Recipes");
                });
#pragma warning restore 612, 618
        }
    }
}