import Link from 'next/link';
import { ReactNode } from 'react';

export default function Layout({ children }: { children: ReactNode }) {
  return (
    <div className="min-h-screen flex flex-col bg-gray-50">
      <header className="bg-white shadow">
        <nav className="max-w-7xl mx-auto px-4 py-4 flex justify-between items-center">
          <h1 className="text-2xl font-bold text-indigo-600">
            <Link href="/">
              Student Stream Selection
            </Link>
          </h1>
          <div className="space-x-4">
            <Link href="/" className="text-gray-700 hover:text-indigo-500">
              Home
            </Link>
            <Link href="/students" className="text-gray-700 hover:text-indigo-500">
              Students
            </Link>
            <Link href="/register" className="text-gray-700 hover:text-indigo-500">
              Register
            </Link>
          </div>
        </nav>
      </header>
      <main className="flex-grow max-w-7xl mx-auto px-4 py-6">
        {children}
      </main>
      <footer className="bg-white border-t py-4 text-center text-sm text-gray-500">
        © {new Date().getFullYear()} Student Stream Selection
      </footer>
    </div>
  );
}
