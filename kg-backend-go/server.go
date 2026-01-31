package main

import (
	"log"

	repo "dashbikash/kg-backend/repository"

	"github.com/gofiber/fiber/v2"
)

func main() {
	app := fiber.New()
	app.Get("/", func(c *fiber.Ctx) error {

		return c.JSON(repo.GetAllPersons())
	})

	log.Fatal(app.Listen(":3000"))
}
