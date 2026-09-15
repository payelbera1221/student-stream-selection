import Layout from '../components/Layout';
import Link from 'next/link';

export default function Home() {
  return (
    <Layout>
      <h2 className="text-xl font-semibold mb-4">Welcome to Student Stream Selection</h2>
      <p className="mb-6">Use the navigation above or the links below to manage students.</p>
      <ul className="list-disc pl-5 space-y-2">
        <li><Link href="/register" className="text-indigo-600 hover:underline">Register New Student</Link></li>
        <li><Link href="/students" className="text-indigo-600 hover:underline">View All Students</Link></li>
        <li><Link href="/select-stream" className="text-indigo-600 hover:underline">Select Stream</Link></li>
        <li><Link href="/approve" className="text-indigo-600 hover:underline">Management Approval</Link></li>
        <li><Link href="/payment" className="text-indigo-600 hover:underline">Make Payment</Link></li>
        <li><Link href="/recheck" className="text-indigo-600 hover:underline">Request Re‑check</Link></li>
      </ul>
    </Layout>
  );
}
