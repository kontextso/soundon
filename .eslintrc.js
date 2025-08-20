/** @type {import("eslint").Linter.Config} */
module.exports = {
  root: true,
  extends: ['@kontextso/eslint-config/react-internal.js'],
  parser: '@typescript-eslint/parser',
  parserOptions: {
    project: './tsconfig.lint.json',
    tsconfigRootDir: __dirname,
  },
  ignorePatterns: ['**/*.js', 'vitest.config.ts'],
}
