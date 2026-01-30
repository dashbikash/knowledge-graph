package main

import (
	"log"

	"dashbikash/kg-backend/repo"

	"github.com/gofiber/fiber/v2"
)

func main() {
	app := fiber.New()

	app.Get("/", func(c *fiber.Ctx) error {
		repo.AddPersons()
		return c.SendString("Hello, World!")
	})

	log.Fatal(app.Listen(":3000"))
}
